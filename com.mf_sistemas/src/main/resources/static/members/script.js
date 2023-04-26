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
async function deleteMember(memberId) {
    try {
        const response = await fetch(`/Members/${memberId}`, {
            method: 'DELETE',
        });
        if(response.ok) {
            console.log(`Member with ID ${memberId} deleted`);
            fetchMembers();
        } else {
            console.error(`Failed to delete member with ID ${memberId}`)
        }
    } catch (error) {
        console.error(`Failed to delete the member with ID ${memberId}`, error);
    }
}
function displayMembers(members) {
    const memberTableBody = document.querySelector('#memberTable tbody');
    memberTableBody.innerHTML = '';
    members.forEach(member => {
        const row = document.createElement('tr');

        const memberIdCell = document.createElement('td');
        memberIdCell.textContent = member.memberId;
        row.appendChild(memberIdCell);

        const memberFullName = document.createElement('td');
        memberFullName.textContent = member.fullName;
        row.appendChild(memberFullName);

        const memberShipTypeCell = document.createElement('td');
        memberShipTypeCell.textContent = member.memberShipType;
        row.appendChild(memberShipTypeCell);

        const startDate = document.createElement('td');
        startDate.textContent = member.startDate;
        row.appendChild(startDate);

        const endDate = document.createElement('td');
        endDate.textContent = member.endDate;
        row.appendChild(endDate);

        const deleteButton = document.createElement('button');
        deleteButton.textContent = 'Delete';
        deleteButton.className = 'delete-btn';
        deleteButton.onclick = () => deleteMember(member.memberId);

        const deleteCell = document.createElement('td');
        deleteCell.appendChild(deleteButton);
        row.appendChild(deleteCell);
        
        memberTableBody.appendChild(row);
    });
}