document.addEventListener('DOMContentLoaded', function () {
    const urlParams = new URLSearchParams(window.location.search);
    const day = urlParams.get('day');
    fetchDailyWorkout(day);
});

async function fetchDailyWorkout(day) {
    // Fetch the workout plan for this day
    const response = await fetch(`/WorkoutPlans?day=${day}`);
    const dailyWorkout = await response.json();

    // Display the workout plan on the page
    displayDailyWorkout(dailyWorkout);
}

function displayDailyWorkout(dailyWorkout) {
    // Code to display the workout plan goes here. 
    // This will be similar to the displayWorkoutPlanDetails function, but for a single day's plan.
}

// Add event listener for the edit button
const editButton = document.getElementById('editButton');
editButton.addEventListener('click', function () {
    // Code to edit the workout plan goes here
});
