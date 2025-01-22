console.log("Hello from the sample code!");

function sendMessageToNative(eventName, message) {
    window.Android.postMessage(eventName, message);
    window.Android.logoutCall( 'logout');

}

function webPageCallback(message) {
console.log("start");
    document.getElementById("message").innerHTML = message;


    }


console.log("new event start");
    // JavaScript code to handle the custom event
        window.addEventListener('OnNotificationClick', (event) => {
          // Extract the detail text from the event
console.log("new event inside", event);
          const detailText = event.detail;
console.log("new event inside2", event.detail);
    document.getElementById("message").innerHTML = detailText;

//          // Print the detail text in the HTML
//          const outputDiv = document.getElementById('output');
//          outputDiv.textContent = `Received detail: ${detailText}`;
        });
