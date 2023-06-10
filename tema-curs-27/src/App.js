
import './App.css';
import Counter from "./Counter";
import WelcomeMessage from "./WelcomeMessage";
import Stopwatch from "./Stopwatch";

function App() {
  return (
      <div className="App">
        <WelcomeMessage />
        <Counter />
        <Stopwatch />
      </div>
  );
}

export default App;