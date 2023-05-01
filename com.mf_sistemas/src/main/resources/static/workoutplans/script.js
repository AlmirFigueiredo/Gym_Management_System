document.addEventListener('DOMContentLoaded', function () {
    fetchWorkoutPlans();
});

function fetchWorkoutPlans() {
    fetch("/WorkoutPlans")
        .then(response => response.json())
        .then(workoutPlans => {
            displayWorkoutPlans(workoutPlans);
        })
        .catch(error => {
            console.error('Error fetching members:', error);
        });
}

function displayWorkoutPlans(workoutPlans) {
    const workoutPlanTable = document.querySelector('#workoutPlanTable tbody');
    workoutPlanTable.innerHTML = '';
    workoutPlans.forEach(workoutPlan => {
        const row = document.createElement('tr');

        const memberIdCell = document.createElement('td');
        memberIdCell.textContent = workoutPlan.member.memberId;
        row.appendChild(memberIdCell);

        const memberNameCell = document.createElement('td');
        memberNameCell.textContent = workoutPlan.member.fullName;
        row.appendChild(memberNameCell);

        const trainerIdCell = document.createElement('td');
        trainerIdCell.textContent = workoutPlan.trainer.trainerId;
        row.appendChild(trainerIdCell);
        
        const startDate = document.createElement('td');
        startDate.textContent = workoutPlan.startDate;
        row.appendChild(startDate);

        const endDate = document.createElement('td');
        endDate.textContent = workoutPlan.endDate;
        row.appendChild(endDate);
        
        row.classList.add('table-row-button');
        row.addEventListener('click', () => {
            window.location.href = 'workoutplan_details/workoutplan_details.html';
        });

        workoutPlanTable.appendChild(row);
    });
}
