import React, {useState, useEffect } from "react";

const Stopwatch = () => {
    const [time, setTime] = useState(0);
    const [running, setRunning] = useState(false);

    useEffect(() =>{
        let intervalId;
        if (running) {
            intervalId =setInterval(() => {
                setTime((prevTime) => prevTime + 1);
            }, 1000);
        }
        return () => {
            clearInterval(intervalId);
        };
    } , [running]);

    const formatTime = (time) => {
        const minutes = Math.floor(time / 60);
        const seconds = time % 60;
        return `${minutes}:${seconds < 10 ? "0" : ""}${seconds}`;
    };

    return (
        <div>
            <p>Time: {formatTime(time)}</p>
            <button onClick={() => setRunning(true)}>Start</button>
            <button onClick={() => setRunning(false)}>Stop</button>
            <button onClick={() => setTime(0)}>Clear</button>
        </div>
    );
};

export default Stopwatch;