function extensibleObject() {
    let object = {
        extend: function (parent) {
            for (let parentProp of Object.keys(parent)) {
                if (typeof parent[parentProp] === "function") {
                    Object.getPrototypeOf(object)[parentProp] = parent[parentProp];
                } else {
                    object[parentProp] = parent[parentProp];
                }
            }
        }
    };

    return object;
}