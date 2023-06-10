import React from "react";
import "./App.css";
import Badge from "./Badge.js";
class App extends React.Component {
  render() {

    const badgesProps = [
      {
        firstName: "Johhny",
        lastName: "Depp",
        img: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRIMJf32XCdIMPR005aLZbkk5TldBubjW2CfA&usqp=CAU",
        birthday: "05/07/1977",
        description: "actor",
        hobbies: "music"
      },
      {
        firstName: "Tommy",
        lastName: "Williams",
        img: "https://thumbs.dreamstime.com/b/default-avatar-photo-placeholder-profile-icon-eps-file-easy-to-edit-default-avatar-photo-placeholder-profile-icon-124557887.jpg",
        birthday: "01/04/1998",
        description: "student",
        hobbies: "java"
      },
      {
        firstName: "Joey",
        lastName: "Harper",
        img: "https://thumbs.dreamstime.com/b/default-avatar-photo-placeholder-profile-icon-eps-file-easy-to-edit-default-avatar-photo-placeholder-profile-icon-124557887.jpg",
        birthday: "11/11/1991",
        description: "coach",
        hobbies: "sports, paintings, react"
      }
    ];

    return (
        <div id="container">

          {badgesProps.map((badge) => (
              <Badge
                  firstName={badge.firstName}
                  lastName={badge.lastName}
                  img={badge.img}
                  birthday={badge.birthday}
                  description={badge.description}
                  hobbies={badge.hobbies}
              />
          ))}

        </div>
    );
  }
}

export default App;