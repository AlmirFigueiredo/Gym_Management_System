document.addEventListener('DOMContentLoaded', function () {
    const urlParams = new URLSearchParams(window.location.search);
    const selectedDay = urlParams.get('day') || new Date().toLocaleString('en-us', { weekday: 'long' });
    fetchDailyWorkout(selectedDay);
});

async function fetchDailyWorkout(day) {
    const response = await fetch(`/DailyWorkouts/day/${day}`);
    if (!response.ok) {
        console.error(`There was an error fetching the workout: ${response.status}`);
        return;
    }
    const dailyWorkout = await response.json();
    if (dailyWorkout && dailyWorkout.exercises) {
        displayDailyWorkout(dailyWorkout);
    } else {
        console.log(`No workout found for day ${day}`);
    }
}

function displayDailyWorkout(dailyWorkout) {
    const tableBody = document.getElementById('workoutTableBody');
    tableBody.innerHTML = '';

    dailyWorkout.exercises.forEach((exercise) => {
        const row = tableBody.insertRow();
        row.innerHTML = `
            <td class="exercise" data-id="${exercise.id}">${exercise.name}</td>
            <td>${exercise.quantitySets}</td>
            <td>${exercise.quantityReps}</td>
            <td>${exercise.resTimeSeconds}</td>
        `;

        row.querySelector('.exercise').addEventListener('click', function () {
            openEditExerciseModal(exercise);
        });
    });
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

    form.onsubmit = function (e) {
        e.preventDefault();

        const updatedExercise = Object.assign({}, originalExercise, {
            name: form.elements['name'].value,
            quantitySets: parseInt(form.elements['quantitySets'].value),
            quantityReps: parseInt(form.elements['quantityReps'].value),
            resTimeSeconds: parseInt(form.elements['resTimeSeconds'].value),
        });

        fetch(`/Exercises/${updatedExercise.id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(updatedExercise),
        });

        modal.style.display = 'none';

        const urlParams = new URLSearchParams(window.location.search);
        const day = urlParams.get('day');
        fetchDailyWorkout(day);
    };
}

function openAddExerciseModal() {
    const form = document.getElementById('exerciseForm');
    form.elements['name'].value = '';
    form.elements['quantitySets'].value = '';
    form.elements['quantityReps'].value = '';
    form.elements['resTimeSeconds'].value = '';

    const modal = document.getElementById('modalBox');
    modal.style.display = 'block';

    const closeButton = document.querySelector('.close');
    closeButton.addEventListener('click', function () {
        modal.style.display = 'none';
    });
}
const closeButton = document.querySelector('.close');
closeButton.addEventListener('click', function () {
    const modal = document.getElementById('modalBox');
    modal.style.display = 'none';
});

const addButton = document.getElementById('addExerciseButton');
addButton.addEventListener('click', openAddExerciseModal);
