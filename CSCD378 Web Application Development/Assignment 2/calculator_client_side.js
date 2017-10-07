$(document).ready(init);

function init() {
    $(".btnNumber").click(btnNumber);
    $(".btnClears").click(btnClears);
    $(".btnCompute").click(btnCompute);
    $("#btnEquals").click(btnEquals);
    $("#btnNegative").click(btnNegative);
}

function btnNegative(evt) {
    var value = -(getVal());
    $("#readout").val(value);
}

function btnClears(evt) {
    var btn = evt.target;
    var keyVal = $(btn).html();

    if (keyVal == "C") {
        clr();
    }
    clr();
}

function btnEquals(evt) {
    var register = $("#register").val();
    var operator = $("#operator").val();
    var result = compute(register, operator);
    $("#readout").val(result);
}

function btnCompute(evt) {
    var btn = evt.target;
    var keyVal = $(btn).html();
    var prevVal = getVal();
    $("#register").val(prevVal);
    $("#operator").val(keyVal);
    clr();
}

function btnNumber(evt) {
    var btn = evt.target;
    var keyVal = $(btn).html();
    var existing = getVal();

    if (keyVal == ".") {
        if (!existing.includes(".")) {
            $("#readout").val(existing + keyVal);
        }
    } else {
        $("#readout").val(existing + keyVal);
    }
}

function getVal() {
    var val = $("#readout").val();
    return val;
}

function clr() {
    $("#readout").val("");
}

function compute(prevVal, operation) {
    var num1 = prevVal;
    var num2 = getVal();
    var result;

    if (operation == "*")
        result = num1 * num2;
    if (operation == "/")
        result = num1 / num2;
    if (operation == "+")
        result = num1 + num2;
    if (operation == "-")
        result = num1 - num2;
    if (operation == "Sq")
        result = Math.sqrt(num1);
    if (operation == "1/x")
        result = 1 / num1;
    if (operation == "%")
        result = num1 / 100;

    return result;
}
