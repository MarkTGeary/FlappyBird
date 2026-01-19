# Flappy Bird - Console Text Game

A simple, minimalist implementation of Flappy Bird created in plain vanilla Java that runs entirely in the console/terminal.

## 🎮 Game Overview

This is a text-based recreation of the classic Flappy Bird game that runs in your terminal. Navigate a bird (represented by a character) through gaps in pipes by timing your jumps correctly!

## 📋 Game Specifications

- **Display Size**: 25 characters wide × 15 characters high
- **Rendering**: Uses ANSI escape codes for in-place printing (single console output)
- **Language**: Pure Java (no external dependencies)
- **Platform**: Cross-platform (Windows, macOS, Linux)

## 🎯 How to Play

### Objective
Guide the bird through as many pipe gaps as possible without colliding with pipes or boundaries.

### Controls
- **SPACE** or **ENTER**: Make the bird jump/flap
- **Q**: Quit the game

### Game Mechanics
- The bird continuously falls due to gravity
- Each jump gives the bird upward momentum
- Pipes move from right to left across the screen
- Score increases as you successfully pass through pipes
- Game ends on collision with pipes, top boundary, or bottom boundary

## 🚀 Getting Started

### Prerequisites
- Java JDK 8 or higher
- Terminal/Console with ANSI escape code support
  - **Windows**: Windows 10+ (Command Prompt or PowerShell with ANSI enabled)
  - **macOS/Linux**: Native terminal support

### Compilation
```bash
javac FlappyBird.java
```

### Running the Game
```bash
java FlappyBird
```

## 🛠️ Technical Details

### In-Place Printing
The game uses ANSI escape sequences to refresh the display without scrolling:
- `\033[H` - Moves cursor to home position (top-left)
- `\033[2J` - Clears the screen
- This creates a smooth animation effect by overwriting the previous frame

### Game Board Representation
```
┌─────────────────────────┐
│                         │
│         @               │  <- Bird
│                  ║      │
│                  ║      │
│                         │  <- Gap in pipe
│                  ║      │
│                  ║      │
│                         │
└─────────────────────────┘
```

### Key Features
- **Real-time Input**: Non-blocking keyboard input for responsive controls
- **Frame-Based Animation**: Consistent game loop with timing control
- **Collision Detection**: Accurate hit detection for pipes and boundaries
- **Score Tracking**: Live score display and game-over statistics
- **Simple Physics**: Gravity simulation and jump mechanics

## 📂 Project Structure

```
FlappyBird/
├── FlappyBird.java    # Main game file with all logic
└── README.md          # This file
```

## 🎨 Game Elements

| Symbol | Description |
|--------|-------------|
| `@` or `●` | The bird |
| `║` | Pipe walls |
| `═` | Ground/ceiling borders |
| `│` | Side borders |
| `└┘┌┐` | Corner borders |

## 🐛 Known Limitations

- Terminal must support ANSI escape codes
- Some terminals may have input lag
- Windows users may need to enable Virtual Terminal Processing
- Game speed depends on system performance

## 🔧 Troubleshooting

### Windows ANSI Issues
If colors/clearing doesn't work on Windows, ensure ANSI support is enabled:
```java
// Add this at the start of your program
System.out.println("\033[0m");
```

Or run in Windows Terminal instead of legacy Command Prompt.

### Input Not Responding
- Make sure your terminal window has focus
- Try running with administrator privileges
- Check that your Java version supports console input

## 📝 Future Enhancements

Potential features for future versions:
- [ ] High score persistence (save to file)
- [ ] Difficulty levels (speed adjustment)
- [ ] Color themes
- [ ] Sound effects (console beep)
- [ ] Multiple bird characters
- [ ] Power-ups and obstacles

## 📜 License

This is a educational project. Feel free to use, modify, and distribute as needed.

## 🙏 Acknowledgments

- Original Flappy Bird game by Dong Nguyen
- Inspired by the classic mobile game mechanics
- Built as a demonstration of console-based game programming in Java

## 👨‍💻 Development

**Language**: Java (Vanilla)  
**Paradigm**: Procedural/Object-Oriented  
**Complexity**: Beginner-Friendly

Perfect for learning:
- Console I/O in Java
- Game loop concepts
- Basic collision detection
- ANSI escape codes
- Real-time user input handling

---

**Happy Flapping! 🐦**
