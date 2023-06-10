document.addEventListener('DOMContentLoaded', function () {
    const urlParams = new URLSearchParams(window.location.search);
    const selectedDay = urlParams.get('day') || new Date().toLocaleString('en-us', { weekday: 'long' });
    fetchDailyWorkout(selectedDay);
});

document.getElementById('addExerciseButton').addEventListener('click', openAddExerciseModal);

async function fetchDailyWorkout(day) {
    const response = await fetch(`/DailyWorkouts/day/${day}`);
    const dailyWorkout = await response.json();
    displayDailyWorkout(dailyWorkout);
}

function displayDailyWorkout(dailyWorkout) {
    const tableBody = document.getElementById('workoutTableBody');
    tableBody.innerHTML = '';

    dailyWorkout.exercises.forEach((exercise) => {
        const row = tableBody.insertRow();
        const nameCell = row.insertCell();
        const setsCell = row.insertCell();
        const repsCell = row.insertCell();
        const restTimeCell = row.insertCell();

        nameCell.innerText = exercise.name;
        setsCell.innerText = exercise.quantitySets;
        repsCell.innerText = exercise.quantityReps;
        restTimeCell.innerText = exercise.resTimeSeconds;

        row.addEventListener('click', function () {
            cloneAndEditExercise(exercise);
        });
    });
}

async function cloneAndEditExercise(exercise) {
    const response = await fetch(`/Exercises/${exercise.id}/clone`, { method: 'POST' });
    const clonedExercise = await response.json();
    openEditExerciseModal(clonedExercise);
}

function openEditExerciseModal(exercise) {
    const originalExercise = Object.assign({}, exercise);
    const form = document.getElementById('exerciseForm');
    form.elements['name'].value = originalExercise.name;
    form.elements['quantitySets'].value = originalExercise.quantitySets;
    form.elements['quantityReps'].value = originalExercise.quantityReps;
    form.elements['resTimeSeconds'].value = originalExercise.resTimeSeconds;

    const modal = document.getElementById('modalBox');
    modal.style.display = 'block';

    form.onsubmit = async function (e) {
        e.preventDefault();

        const updatedExercise = Object.assign({}, originalExercise, {
            name: form.elements['name'].value,
            quantitySets: parseInt(form.elements['quantitySets'].value),
            quantityReps: parseInt(form.elements['quantityReps'].value),
            resTimeSeconds: parseInt(form.elements['resTimeSeconds'].value),
        });

        await fetch(`/Exercises/${updatedExercise.id}`, {
            method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(updatedExercise),
        });

        modal.style.display = 'none';

        const urlParams = new URLSearchParams(window.location.search);
        const day = urlParams.get('day');
        fetchDailyWorkout(day);
    };

    const closeModalButton = document.getElementById('closeModal');
    closeModalButton.addEventListener('click', function () {
        modal.style.display = 'none';
    });

    const deleteButton = document.getElementById('deleteButton');
    deleteButton.addEventListener('click', function () {
        deleteExercise(exercise.id);
    });
}

async function deleteExercise(id) {
    const confirmation = confirm('Are you sure you want to delete this exercise?');
    if (confirmation) {
        await fetch(`/Exercises/${id}`, { method: 'DELETE' });

        const urlParams = new URLSearchParams(window.location.search);
        const day = urlParams.get('day');
        fetchDailyWorkout(day);
    }
}

function openAddExerciseModal() {
    const form = document.getElementById('exerciseForm');
    form.reset();

    const modal = document.getElementById('modalBox');
    modal.style.display = 'block';

    form.onsubmit = async function (e) {
        e.preventDefault();

        const newExercise = {
            name: form.elements['name'].value,
            quantitySets: parseInt(form.elements['quantitySets'].value),
            quantityReps: parseInt(form.elements['quantityReps'].value),
            resTimeSeconds: parseInt(form.elements['resTimeSeconds'].value),
        };

        await fetch('/Exercises', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(newExercise),
        });

        modal.style.display = 'none';

        const urlParams = new URLSearchParams(window.location.search);
        const day = urlParams.get('day');
        fetchDailyWorkout(day);
    };
}
