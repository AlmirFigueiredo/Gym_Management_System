document.addEventListener('DOMContentLoaded', function () {
    const urlParams = new URLSearchParams(window.location.search);
    const memberId = urlParams.get('memberId');

    if (memberId) {
        fetchMemberDetails(memberId);
    } else {
        window.location.href = '../index.html';
    }
});

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

    const workoutPlanButton = document.getElementById('workoutPlanButton');
    workoutPlanButton.addEventListener('click', function () {
        window.location.href = ``;
    });
}
