document.addEventListener('DOMContentLoaded', function () {
    fetchWorkoutPlans();
});

function fetchWorkoutPlans() {
    fetch("/WorkoutPlans")
        .then((response) => response.json())
        .then(async (workoutPlans) => {
            const workoutPlansWithDetails = await Promise.all(
                workoutPlans.map(async (workoutPlan) => {
                    const memberResponse = await fetch(`/Members/${workoutPlan.memberId}`);
                    const member = await memberResponse.json();
                    const trainerResponse = await fetch(`/Trainers/${workoutPlan.trainerId}`);
                    const trainer = await trainerResponse.json();
                    return { ...workoutPlan, member, trainer };
                })
            );
            displayWorkoutPlans(workoutPlansWithDetails);
        })
        .catch((error) => {
            console.error("Error fetching:", error);
        });
}

function displayWorkoutPlans(workoutPlans) {
    const workoutPlanTable = document.querySelector('#workoutPlanTable tbody');
    workoutPlanTable.innerHTML = '';
    workoutPlans.forEach(workoutPlan => {
        const row = document.createElement('tr');

        const memberIdCell = document.createElement('td');
        memberIdCell.textContent = workoutPlan.memberId ? workoutPlan.memberId : 'N/A';
        row.appendChild(memberIdCell);

        const memberNameCell = document.createElement('td');
        memberNameCell.textContent = workoutPlan.member ? workoutPlan.member.fullName : 'N/A';
        row.appendChild(memberNameCell);

        const trainerIdCell = document.createElement('td');
        trainerIdCell.textContent = workoutPlan.trainerId ? workoutPlan.trainerId : 'N/A';
        row.appendChild(trainerIdCell);

        const startDate = document.createElement('td');
        startDate.textContent = workoutPlan.startDate;
        row.appendChild(startDate);

        const endDate = document.createElement('td');
        endDate.textContent = workoutPlan.endDate;
        row.appendChild(endDate);

        row.classList.add('table-row-button');
        row.addEventListener('click', () => {
            window.location.href = `workoutplan_details/workoutplan_details.html?workoutPlanId=${workoutPlan.id}`;
        });
        workoutPlanTable.appendChild(row);
    });
}

