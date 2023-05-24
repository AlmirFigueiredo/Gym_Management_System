document.getElementById('editMemberForm').addEventListener('submit', submitForm);

async function fetchMemberDetails(memberId) {
    try {
        const response = await fetch(`/Members/${memberId}`);
        const member = await response.json();
        displayMemberDetails(member);
    } catch (error) {
        console.error('Error fetching member details:', error);
    }
}

function displayMemberDetails(member) {
    document.getElementById('memberId').value = member.id;
    document.getElementById('fullName').value = member.fullName;
    document.getElementById('memberShipType').value = member.memberShipType;
    document.getElementById('startDate').value = member.startDate;
    document.getElementById('endDate').value = member.endDate;
    document.getElementById('email').value = member.email;
    document.getElementById('address').value = member.address;
    document.getElementById('phoneNumber').value = member.phoneNumber;
}

async function updateMember(memberId, memberInfo) {
    try {
        const response = await fetch(`/Members/${memberId}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(memberInfo),
        });
        if (response.ok) {
            alert('Member updated successfully');
        } else {
            alert('Failed to update member');
        }
    } catch (error) {
        console.error('Error updating member:', error);
    }
}

function submitForm(event) {
    event.preventDefault();

    const memberId = document.getElementById('memberId').value;
    const fullName = document.getElementById('fullName').value;
    const memberShipType = document.getElementById('memberShipType').value;
    const startDate = document.getElementById('startDate').value;
    const endDate = document.getElementById('endDate').value;
    const email = document.getElementById('email').value;
    const address = document.getElementById('address').value;
    const phoneNumber = document.getElementById('phoneNumber').value;

    const updatedMember = {
        fullName: fullName,
        memberShipType: memberShipType,
        startDate: startDate,
        endDate: endDate,
        email: email,
        address: address,
        phoneNumber: phoneNumber
    };
    
    updateMember(memberId, updatedMember);
}

document.addEventListener('DOMContentLoaded', function () {
    const urlParams = new URLSearchParams(window.location.search);
    const memberId = urlParams.get('memberId');

    if (memberId) {
        fetchMemberDetails(memberId);
    } else {
        window.location.href = '../index.html';
    }
});
