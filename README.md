# Flappy Bird - Console Text Game

A simple, turn-based implementation of Flappy Bird created in plain vanilla Java that runs entirely in the console/terminal. Control the bird's vertical position as pipes scroll past from right to left.

## 🎮 Game Overview

This is a text-based, turn-based recreation of the classic Flappy Bird game that runs in your terminal. Navigate a bird (represented by the character `o`) through gaps in pipes by controlling its vertical position with W and S keys!

## 📋 Game Specifications

- **Display Size**: 25 characters wide × 15 characters high
- **Rendering**: Console clearing between frames for screen updates
- **Input Style**: Turn-based (waits for player input each step)
- **Language**: Pure Java (no external dependencies, uses Scanner for input)
- **Platform**: Cross-platform (Windows, macOS, Linux)

## 🎯 How to Play

### Objective
Guide the bird through as many pipe gaps as possible without colliding with pipes or boundaries.

### Controls
- **W**: Move the bird up
- **S**: Move the bird down
- **Q**: Quit the game

### Game Mechanics
- The bird stays in the leftmost column and you control its vertical position
- Pipes move from right to left across the screen
- Each move requires manual input (turn-based style)
- Score increases as you successfully pass through pipe gaps
- Game ends on collision with pipes, top boundary, or bottom boundary

## 🚀 Getting Started

### Prerequisites
- Java JDK 8 or higher
- Terminal/Console application (best results in native terminals)
  - **Windows**: Command Prompt or PowerShell
  - **macOS/Linux**: Terminal.app, iTerm, or any standard terminal
- Note: Works best outside of IDE consoles

### Compilation
```bash
javac FlappyBird.java
```

### Running the Game
```bash
java FlappyBird
```

## 🛠️ Technical Details

### Game Constants
```java
ARRAY_WIDTH = 25          // Game board width
ARRAY_HEIGHT = 15         // Game board height
PIPE_WIDTH = 1           // Width of pipe columns
GAP_BETWEEN_PIPES = 5    // Spaces between pipe pairs
SPACE_FOR_BIRD = 4       // Size of gap in pipes for bird to pass through
```

### Screen Clearing
The game clears the console between each frame:
- **Windows**: Uses `cmd /c cls` command via ProcessBuilder
- **macOS/Linux**: Uses ANSI escape sequences (`\033[H\033[2J`)
- **Fallback**: Prints 50 newlines if other methods fail
- This refreshes the display for each game state update

### Game Board Representation
```
Flappy Bird Game - Score: 0
                         
o                        
                  ║      
                  ║      
                         
                  ║      
                  ║      
                         
```
The bird (`o`) stays in the leftmost column. Pipes (`║`) scroll from right to left with gaps for the bird to pass through.

### Key Features
- **Turn-Based Input**: Scanner-based keyboard input (blocking, waits for player action)
- **Step-Based Animation**: Game updates after each player input
- **Collision Detection**: Accurate hit detection for pipes and boundaries
- **Score Tracking**: Live score display and game-over statistics
- **Simple Movement**: Direct vertical control without gravity simulation

## 📂 Project Structure

```
FlappyBird/
├── FlappyBird.java    # Main game file with all logic
└── README.md          # This file
```

## 🎨 Game Elements

| Symbol | Description |
|--------|-------------|
| `o` | The bird |
| `║` | Pipe walls |
| (space) | Empty space / gaps |

## 🐛 Known Limitations

- Game is turn-based (not real-time) - waits for input after each move
- No gravity simulation - bird position is manually controlled
- Console clearing may not work in all terminal environments
- Best played in a native terminal (Command Prompt, PowerShell, Terminal.app)
- May not work properly in IDE embedded consoles
- Requires pressing Enter after each W/S input

## 🔧 Troubleshooting

### Console Not Clearing Properly
If the console doesn't clear properly:
- **Windows**: Make sure you're running in Command Prompt or PowerShell (not IDE console)
- **macOS/Linux**: Most terminals support ANSI codes by default
- The game includes a fallback that prints newlines if clearing fails

### Input Not Responding
- Make sure your terminal window has focus
- The game waits for you to type W, S, or Q and press Enter
- Check that your Java version supports Scanner input from System.in

## 📝 Future Enhancements

Potential features for future versions:
- [ ] Add gravity simulation and automatic falling
- [ ] Implement non-blocking real-time input
- [ ] High score persistence (save to file)
- [ ] Difficulty levels (pipe gap size, spacing adjustment)
- [ ] Color themes using ANSI color codes
- [ ] Sound effects (console beep)
- [ ] Multiple bird characters
- [ ] Borders and enhanced visual elements

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
- 2D array manipulation
- Basic collision detection
- Console clearing techniques (cross-platform)
- Turn-based game logic
- Random number generation for procedural content

---

**Happy Flapping! 🐦**
