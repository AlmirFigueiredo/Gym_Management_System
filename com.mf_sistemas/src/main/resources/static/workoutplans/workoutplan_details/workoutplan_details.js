document.addEventListener('DOMContentLoaded', function () {
    const workoutPlanId = 1;
    fetchWorkoutPlanDetails(workoutPlanId);
});

function fetchWorkoutPlanDetails(workoutPlanId) {
    fetch('/WorkoutPlans/${workoutPlanId}')
        .then(response => response.json())
        .then(workoutPlan => {
            displayWorkoutPlanDetails(workoutPlan);
        })
        .catch(error => {
            console.error('Error fetching workout plan details:', error);
        });
}

function displayWorkoutPlanDetails(workoutPlan) {
    if (!workoutPlan) {
        console.error('Workout plan object is undefined.');
        return;
    }

    const memberIdElement = document.querySelector('#memberId');
    const memberNameElement = document.querySelector('#memberName');
    const trainerIdElement = document.querySelector('#trainerId');
    const startDateElement = document.querySelector('#startDate');
    const endDateElement = document.querySelector('#endDate');
    const exercisesListElement = document.querySelector('#exercisesList');

    if (workoutPlan.member) {
        memberIdElement.textContent = workoutPlan.member.memberId || '';
        memberNameElement.textContent = workoutPlan.member.fullName || '';
    }

    if (workoutPlan.trainer) {
        trainerIdElement.textContent = workoutPlan.trainer.trainerId || '';
    }

    startDateElement.textContent = workoutPlan.startDate || '';
    endDateElement.textContent = workoutPlan.endDate || '';

    if (workoutPlan.exercises) {
        workoutPlan.exercises.forEach(exercise => {
            const listItem = document.createElement('li');
            listItem.textContent = exercise.name;
            exercisesListElement.appendChild(listItem);
        });
    }
}

