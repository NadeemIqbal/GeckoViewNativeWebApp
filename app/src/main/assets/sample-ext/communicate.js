console.log("Content:start!");

const port = browser.runtime.connectNative("browser");
//https://developer.mozilla.org/en-US/docs/Mozilla/Add-ons/WebExtensions/Sharing_objects_with_page_scripts
 let Android = {
     postMessage: function (eventName, message) {
         console.log("postMessage start");

         console.log("postMessage: eventName=",eventName,": message=",message);
         port.postMessage(message);


         // TODO: these below 2 lines = evaluateJavaScript
         const event = new CustomEvent(eventName, { detail: message });
         window.dispatchEvent(event); // Dispatch the event to the page

         console.log("postMessage end");
     },
              logoutCall:function(hello){
                  console.log("logoutCall");
                  port.postMessage({functionName:'logoutCall', param:hello});
              }
 }

//let Android = new Proxy(
//    {
//        postMessage: function (eventName, message) {
//            console.log("postMessage start");
//
//            // Ensure the message is serializable
//            const safeMessage = {
//                eventName: eventName,
//                message: JSON.stringify(message), // Convert to string if necessary
//            };
//
//            console.log("Sending message:", safeMessage);
//            port.postMessage(safeMessage);
//
//            const event = new CustomEvent(eventName, { detail: message });
//            window.dispatchEvent(event);
//
//            console.log("postMessage end");
//        },
//        logoutCall:function(hello){
//            console.log("logoutCall");
//        }
//    },
//    {
//        get(target, propKey) {
//            if (propKey in target) {
//                return target[propKey];
//            }
//
//            return (...args) => {
//                console.log(`Dynamic function "${propKey}" called with arguments:`, args);
//                const safeArgs = args.map((arg) =>
//                    typeof arg === "object" ? JSON.stringify(arg) : arg
//                );
//                port.postMessage({ method: propKey, args: safeArgs });
//
//                const event = new CustomEvent(propKey, { detail: safeArgs });
//                window.dispatchEvent(event);
//            };
//        },
//    }
//);

window.wrappedJSObject.Android = cloneInto(Android, window, { cloneFunctions: true });

port.onMessage.addListener((message) => {
    console.log("Received message from native app:", message.text);
    if (window.wrappedJSObject && window.wrappedJSObject.webPageCallback) {
        window.wrappedJSObject.webPageCallback(message.text);
    }
});
