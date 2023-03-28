import { useEffect, useState } from "react";


function DateEvent() {
    const [data, setData] = useState(null);

    useEffect(() => {
        fetch(
            'http://localhost:8080/api/events'
        )
        .then((response) => response.json())
        .then(setData);
    }, []);
    if(data)
    return (
        <pre>{JSON.stringify(data, null, 2)}</pre>
    );
    return <h1>Data</h1>
}

export default DateEvent;