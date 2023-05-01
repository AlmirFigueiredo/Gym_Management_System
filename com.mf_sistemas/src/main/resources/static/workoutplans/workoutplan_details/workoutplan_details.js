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
    document.querySelector('#memberId').textContent = workoutPlan.member.memberId;
    document.querySelector('#memberName').textContent = workoutPlan.member.fullName;
    document.querySelector('#trainerId').textContent = workoutPlan.trainer.trainerId;
    document.querySelector('#startDate').textContent = workoutPlan.startDate;
    document.querySelector('#endDate').textContent = workoutPlan.endDate;

    const exerciseList = document.querySelector('#exercisesList');
    workoutPlan.exercises.forEach(exercise => {
        const listItem = document.createElement('li');
        listItem.textContent = exercise.name;
        exerciseList.appendChild(listItem)
    });
}
