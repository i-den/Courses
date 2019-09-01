function requestValidator(request) {
    // Method
    let validMethods = ["GET", "POST", "DELETE", "CONNECT"];
    if (!validMethods.includes(request.method)) {
        throw new Error("Invalid request header: Invalid Method");
    }

    // URI
    let validURIRegex = /^[a-zA-Z0-9.]+$/;
    if (!validURIRegex.test(request.uri) || !request.hasOwnProperty("uri")) {
        throw new Error("Invalid request header: Invalid URI");
    }

    // HTTP Version
    let validVersions = ["HTTP/0.9","HTTP/1.0", "HTTP/1.1", "HTTP/2.0"];
    if (!validVersions.includes(request.version)) {
        throw new Error("Invalid request header: Invalid Version");
    }

    // Message
    let validMessageRegex = /^[^<>\\&'"]*$/;
    if (!validMessageRegex.test(request.message) || !request.hasOwnProperty("message")) {
        throw new Error("Invalid request header: Invalid Message");
    }

    return request;
}

requestValidator({
    method: 'GET',
    uri: 'svn.public.catalog',
    version: 'HTTP/1.1'
})