function getMenu() {
    var tests;
    $.ajax({
        type: 'POST',
        url: "getMenu",
        cache: false,
        timeout: 30000,
        success: function(jsonObject) {
            tests = jsonObject;
        },
    });
    return tests;
}

function getTest(testId) {
    var tests;
    $.ajax({
        type: 'POST',
        url: "getTest?testId="+testId,
        cache: false,
        timeout: 30000,
        success: function(jsonObject) {
            tests = jsonObject;
        },
    });
    return tests;
}

function getText(sectionPath) {
    var tests;
    $.ajax({
        type: 'POST',
        url: "getText?sectionPath="+sectionPath,
        cache: false,
        timeout: 30000,
        success: function(jsonObject) {
            tests = jsonObject;
        },
    });
    return tests;
}