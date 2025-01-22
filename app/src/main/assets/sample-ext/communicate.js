console.log('Content:start!');

//https://developer.mozilla.org/en-US/docs/Mozilla/Add-ons/WebExtensions/API/runtime/connectNative
const port = browser.runtime.connectNative("browser");

//https://developer.mozilla.org/en-US/docs/Mozilla/Add-ons/WebExtensions/Sharing_objects_with_page_scripts
let JSBridge = {
    postMessage: function (eventName, message) {
        console.log("postMessage start");

        port.postMessage(message);

        const event = new CustomEvent(eventName, { detail: message });
        window.dispatchEvent(event); // Dispatch the event to the page

        console.log("postMessage end");
    }
}

window.wrappedJSObject.JSBridge = cloneInto(
    JSBridge,
    window,
    { cloneFunctions: true });

port.onMessage.addListener(message => {
    console.log("Received message from native app: " + message.text);

//    window.webPageCallback(message.text);
    if (window.wrappedJSObject && window.wrappedJSObject.webPageCallback) {
        window.wrappedJSObject.webPageCallback(message.text);
    }
});