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
    document.querySelector('.close').addEventListener('click', () => {
        document.getElementById('trainerModal').style.display = 'none';
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
    const trainersList = document.getElementById('trainersList');
    trainersList.innerHTML = '';
    trainers.forEach(trainer => {
        const trainerBox = document.createElement('div');
        trainerBox.className = 'trainer-box';
        trainerBox.textContent = `${trainer.fullName} (ID: ${trainer.trainerId})`;
        trainerBox.onclick = () => {
            window.location.href = `../../workoutplans/workoutplan_details/workoutplan_details.html?workoutPlanId=${memberId}${trainer.trainerId}`;
        };
        trainersList.appendChild(trainerBox);
    });
    const trainerModal = document.getElementById('trainerModal');
    trainerModal.style.display = 'block';
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
