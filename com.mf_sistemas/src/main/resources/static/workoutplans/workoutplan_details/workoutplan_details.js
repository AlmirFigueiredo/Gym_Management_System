document.addEventListener('DOMContentLoaded', function () {
    const urlParams = new URLSearchParams(window.location.search);
    const workoutPlanId = urlParams.get('workoutPlanId');
    fetchWorkoutPlanDetails(workoutPlanId);
});

async function fetchWorkoutPlanDetails(workoutPlanId) {
    try {
        const response = await fetch(`/WorkoutPlans/${workoutPlanId}`);
        const workoutPlan = await response.json();
        for (let i = 0; i < workoutPlan.dailyWorkouts.length; i++) {
            const dailyWorkoutResponse = await fetch(`/DailyWorkouts/${workoutPlan.dailyWorkouts[i].id}`);
            const dailyWorkout = await dailyWorkoutResponse.json();
            for (let j = 0; j < dailyWorkout.exercises.length; j++) {
                const exerciseResponse = await fetch(`/Exercises/${dailyWorkout.exercises[j].id}`);
                const exercise = await exerciseResponse.json();

                if (exercise && exercise.name) {
                    dailyWorkout.exercises[j] = exercise;
                }
            }

            workoutPlan.dailyWorkouts[i] = dailyWorkout;
        }
        const memberResponse = await fetch(`/Members/${workoutPlan.memberId}`);
        const member = await memberResponse.json();
        const trainerResponse = await fetch(`/Trainers/${workoutPlan.trainerId}`);
        const trainer = await trainerResponse.json();
        displayWorkoutPlanDetails({ ...workoutPlan, member, trainer });
    } catch (error) {
        console.error('Error fetching workout plan details:', error);
    }
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

    if (workoutPlan.member) {
        memberIdElement.textContent = workoutPlan.member.memberId || '';
        memberNameElement.textContent = workoutPlan.member.fullName || '';
    }

    if (workoutPlan.trainer) {
        trainerIdElement.textContent = workoutPlan.trainer.trainerId || '';
    }

    startDateElement.textContent = workoutPlan.startDate || '';
    endDateElement.textContent = workoutPlan.endDate || '';

    const daysOfWeek = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];

    daysOfWeek.forEach(day => {
        const dailyWorkoutsForDay = workoutPlan.dailyWorkouts.filter(dailyWorkout => dailyWorkout.dayOfWeek === day);

        const dayTable = document.createElement('table');
        const tableHeader = document.createElement('th');
        tableHeader.textContent = day;
        dayTable.appendChild(tableHeader);

        if (dailyWorkoutsForDay.length === 0) {
            const row = document.createElement('tr');
            const cell = document.createElement('td');
            cell.textContent = 'No workout available';
            row.appendChild(cell);
            dayTable.appendChild(row);
        } else {
            dailyWorkoutsForDay.forEach(dailyWorkout => {
                if (dailyWorkout.exercises) {
                    dailyWorkout.exercises.forEach(exercise => {
                        if (exercise && exercise.name) {
                            const row = document.createElement('tr');
                            const cell = document.createElement('td');
                            cell.textContent = `${exercise.name} - Sets: ${exercise.quantitySets}, Reps: ${exercise.quantityReps}`;
                            row.appendChild(cell);
                            dayTable.appendChild(row);
                        }
                    });
                }
            });
        }
        document.body.appendChild(dayTable);
    });
}

