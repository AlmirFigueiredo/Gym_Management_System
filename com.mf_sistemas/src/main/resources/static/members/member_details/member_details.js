document.addEventListener('DOMContentLoaded', function () {
    const urlParams = new URLSearchParams(window.location.search);
    const memberId = urlParams.get('memberId');

    if (memberId) {
        fetchMemberDetails(memberId);
    } else {
        window.location.href = '../index.html';
    }
    const deleteButton = document.getElementById('deleteButton');
    deleteButton.addEventListener('click', function () {
        deleteMember(memberId);
    });
    const workoutPlanButton = document.getElementById('workoutPlanButton');
    workoutPlanButton.addEventListener('click', function (event) {
        event.preventDefault();
        fetchTrainers(memberId);
    });
});
function fetchTrainers(memberId) {
    fetch(`/Trainers`)
        .then(response => response.json())
        .then(trainers => {
            displayTrainers(memberId, trainers);
        })
        .catch(error => {
            console.error('Error fetching trainer details:', error);
        });
}

function displayTrainers(memberId, trainers) {
    const trainerDropdown = document.getElementById('trainerDropdown');
    trainerDropdown.innerHTML = '';
    trainerDropdown.style.display = 'block';

    trainers.forEach(trainer => {
        const trainerElement = document.createElement('a');
        trainerElement.textContent = `${trainer.name} (ID: ${trainer.trainerId})`;
        trainerElement.href = `../../workoutplans/workoutplan_details/workoutplan_details.html?workoutPlanId=${memberId}${trainer.trainerId}`;

        trainerDropdown.appendChild(trainerElement);
    });
}


function fetchMemberDetails(memberId) {
    fetch(`/Members/${memberId}`)
        .then(response => response.json())
        .then(member => {
            displayMemberDetails(member);
        })
        .catch(error => {
            console.error('Error fetching member details:', error);
        });
}

function displayMemberDetails(member) {
    document.querySelector('#memberId').textContent = member.memberId;
    document.querySelector('#fullName').textContent = member.fullName;
    document.querySelector('#memberShipType').textContent = member.memberShipType;
    document.querySelector('#startDate').textContent = member.startDate;
    document.querySelector('#endDate').textContent = member.endDate;
    document.querySelector('#email').textContent = member.email;
    document.querySelector('#address').textContent = member.address;
    document.querySelector('#phoneNumber').textContent = member.phoneNumber;
}

function deleteMember(memberId) {
    const confirmation = confirm("Do you want to delete this member?");
    if (confirmation) {
        fetch(`/Members/${memberId}`, {
            method: 'DELETE'
        })
            .then(response => {
                if (response.ok) {
                    alert('Member deleted successfully');
                    window.location.href = '../index.html';
                } else {
                    alert('Error deleting member');
                }
            })
            .catch(error => {
                console.error('Error deleting member:', error);
            });
    }
}
