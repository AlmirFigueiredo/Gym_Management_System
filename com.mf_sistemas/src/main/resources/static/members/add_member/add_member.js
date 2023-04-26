document.getElementById('addMemberForm').addEventListener('submit', submitForm);

async function createNewMember(memberInfo) {
    try {
        const response = await fetch('/Members', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(memberInfo),
        });
        if(response.ok) {
            alert('New member created succesfully');
        } else {
            alert('Failed to create new member');
        }
    } catch (error) {
        console.error('Error creating new member:', error);
    }
}


function submitForm(event) {
    event.preventDefault();

    const fullName = document.getElementById('fullName').value;
    const memberShipType = document.getElementById('memberShipType').value;
    const startDate = document.getElementById('startDate').value;
    const endDate = document.getElementById('endDate').value
    const email = document.getElementById('email').value;
    const address = document.getElementById('email').value;
    const phoneNumber = document.getElementById('phoneNumber').value;
    
    const newMember = {
        fullName: fullName,
        memberShipType: memberShipType,
        startDate: startDate,
        endDate: endDate,
        email: email,
        address: address,
        phoneNumber: phoneNumber
    }
    createNewMember(newMember);
}

