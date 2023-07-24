const url = 'ws://localhost:8080/ws';

async function start() {
    let msgToSend = document.getElementById("messageInput").value;
    const ws = await connectToServer(); 

    msgObj = {
        "contenuto": msgToSend
    }

    ws.send(JSON.stringify(msgObj));

    ws.onmessage = (WebSocketMessage) => {
        console.log(WebSocketMessage);
        const messageBody = JSON.parse(WebSocketMessage.data);
        insertDiv(messageBody.msg);
    }    

}

async function connectToServer() {    
    const ws = new WebSocket(url);
    return new Promise((resolve, reject) => {
        const timer = setInterval(() => {
            if(ws.readyState === 1) {
                clearInterval(timer);
                resolve(ws);
            }
        }, 10);
    });   
}

function insertDiv(text) {
    // Create a new <div> element
    var newDiv = document.createElement('div');

    console.log(text);
    
    // Set the text content of the <div>
    var divText = document.createTextNode(text);
    newDiv.appendChild(divText);
    
    // Find the container element
    var container = document.getElementById('daInserire');
    
    // Append the new <div> to the container
    container.appendChild(newDiv);
}