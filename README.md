# Cops and Robbers

A Java GUI program utilizing an object oriented approach to simulate Cops and Robbers!

## Installation

The following Java packages are required

```java
import javax.swing.JFrame;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
```

## Usage

```bash
javac Controller.java
java Controller
```

**After execution, the following window will appear:**

![main](/images/Main.png)

On keypress **'s'**, the game will start

On **left click**, a robber will be created at the bank, the next click will create a cop car (create as many Cops and Robbers as desired)

On keypress **'n'**, the console will log:
```bash
Robbers Ecaped|Captured: numEscaped|numCaptured
```
On keypress **'r'**, the game will reset!

Have fun!

![jailed](/images/jailed.png)

## License
[MIT](https://choosealicense.com/licenses/mit/)
