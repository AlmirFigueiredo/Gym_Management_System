document.addEventListener('DOMContentLoaded', function () {
    fetchMembers();
});

function fetchMembers() {
    fetch("/Members")
        .then(response => response.json())
        .then(members => {
            displayMembers(members);
        })
        .catch(error => {
            console.error('Error fetching members:', error);
        });
}
function displayMembers(members) {
    const memberTableBody = document.querySelector('#memberTable tbody');
    memberTableBody.innerHTML = '';
    members.forEach(member => {
        const row = document.createElement('tr');

        const memberIdCell = document.createElement('td');
        memberIdCell.textContent = member.memberId;
        row.appendChild(memberIdCell);

        const memberShipTypeCell = document.createElement('td');
        memberShipTypeCell.textContent = member.memberShipType;
        row.appendChild(memberShipTypeCell);

        memberTableBody.appendChild(row);
    });
}