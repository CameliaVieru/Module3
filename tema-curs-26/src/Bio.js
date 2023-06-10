import React from "react";

class Bio extends React.Component {
    render() {
        const {birthday, description, hobbies} = this.props;
        const isProgrammer = hobbies.includes("java") || hobbies.includes("react");

        return (
            <div>
                <b>Birthday: </b> {birthday}
                <p></p>
                <b>About: </b> {description}
                <p></p>
                <b>Are you a programmer: </b>{isProgrammer ? "TRUE" : "FALSE"}
            </div>
        );
    }
};

export default Bio;