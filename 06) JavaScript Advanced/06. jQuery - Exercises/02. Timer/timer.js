function timer() {
    let startBtn = $("#start-timer");
    let stopBtn = $("#stop-timer");
    let timer;
    let totalSecs = 0;

    startBtn.click(startTimer);
    stopBtn.click(stopTimer);
    let started = false;

    function startTimer() {
        if (started) {
            return;
        }

        started = true;
        timer = setInterval(step, 1000);
    }

    function stopTimer() {
        started = false;
        clearInterval(timer);
    }

    function step() {
        totalSecs++;
        let hours = ('0' + (Math.trunc(totalSecs / 60 / 60) % 24)).substr(-2);
        let minutes = ('0' + (Math.trunc(totalSecs / 60) % 60)).substr(-2);

        $("#hours").text(hours);
        $("#minutes").text(minutes);
        $("#seconds").text(('0' + (totalSecs % 60)).substr(-2));
    }
}