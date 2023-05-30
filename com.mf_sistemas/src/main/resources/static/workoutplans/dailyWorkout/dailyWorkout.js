document.addEventListener('DOMContentLoaded', function () {
    const urlParams = new URLSearchParams(window.location.search);
    const day = urlParams.get('day');
    fetchDailyWorkout(day);

    const modalBox = document.getElementById('modalBox');
    const closeSpan = document.getElementsByClassName('close')[0];
    const saveButton = document.getElementById('saveButton');

    closeSpan.onclick = function () {
        modalBox.style.display = 'none';
    }
    window.onclick = function (event) {
        if (event.target == modalBox) {
            modalBox.style.display = 'none';
        }
    }
    saveButton.onclick = modifyExercise;
});

async function fetchDailyWorkout(day) {
    const response = await fetch(`/WorkoutPlans?day=${day}`);
    const dailyWorkout = await response.json();
    displayDailyWorkout(dailyWorkout);
}

function displayDailyWorkout(dailyWorkout) {
    const tbody = document.getElementById('workoutTable').getElementsByTagName('tbody')[0];
    dailyWorkout.exercises.forEach(exercise => {
        let row = tbody.insertRow();
        row.insertCell().innerHTML = exercise.name;
        row.insertCell().innerHTML = exercise.quantitySets;
        row.insertCell().innerHTML = exercise.quantityReps;
        row.insertCell().innerHTML = exercise.resTimeSeconds;
        let cell = row.insertCell();
        let editButton = document.createElement('button');
        editButton.innerText = 'Edit';
        editButton.addEventListener('click', function () {
            showEditModal(exercise.id);
        });
        cell.appendChild(editButton);
    });
}

function showEditModal(exerciseId) {
    fetch(`/Exercises/${exerciseId}`)
        .then(response => response.json())
        .then(exercise => {
            document.getElementById('name').value = exercise.name;
            document.getElementById('quantitySets').value = exercise.quantitySets;
            document.getElementById('quantityReps').value = exercise.quantityReps;
            document.getElementById('resTimeSeconds').value = exercise.resTimeSeconds;
            document.getElementById('modalBox').style.display = 'block';
        });
}

async function modifyExercise() {
    const exerciseId = document.getElementById('exerciseId').value;
    const response = await fetch(`/Exercises/${exerciseId}`);
    const exercise = await response.json();
    const newExercise = { ...exercise };
    newExercise.name = document.getElementById('name').value;
    newExercise.quantitySets = document.getElementById('quantitySets').value;
    newExercise.quantityReps = document.getElementById('quantityReps').value;
    newExercise.resTimeSeconds = document.getElementById('resTimeSeconds').value;
    await fetch('/Exercises', {
        method: 'POST',
        body: JSON.stringify(newExercise),
        headers: {
            'Content-Type': 'application/json'
        }
    });
    document.getElementById('modalBox').style.display = 'none';
    fetchDailyWorkout(newExercise.day);
}
