# Keyboard Script Reader

> This is a keyboard script reader originally created for Tatsu Discord bot farming. <br>
> [Tatsu Bot Website](https://tatsu.gg/)

### Key Features

- Keyboard scripting only
- Describe repeat count for each command and whole script block
- Describe offset/delay for each command and whole script block
- Looping and nested looping
- Script naming

## Getting Started

[Download From Here](https://github.com/ahming2000/keyboard-scripting-reader/releases)

> You are required to install [Java 8 or later edition](https://java.com/) in order to use this program.

## Support
Any suggestions feel free to contact me or make a pull request!
> Discord: **AhMing#2702**<br>
> Email: [keeshengming@outlook.com](mailto:keeshengming@outlook.com)

## Guideline

> Step 1: Create a text (`.txt`) file for writing the script. <br> 
> Step 2: Launcher the program and load the text file. <br>
> Step 3: Press `BACKSPACE` (Right side of the =+ key) to start the script!

## Script Syntax

```
type:<sentence> offset:<delay in milliseconds> repeat:<repeat count>
```

```
press:<key syntax> offset:<delay in milliseconds> repeat:<repeat count>
```

> - `offset:` and `repeat:` prefix are **optional**
> - Offset has a default value of `100` milliseconds
> - Repeat count has a default value of `1`, `0` repeat count will count as repeat 1 time
> - Sentence can include space within the text you want to type
> - You may refer to the [examples](https://github.com/ahming2000/keyboard-scripting-reader#examples) which also included in the application folder 

### Header (Optional)

```
main:<script name> offset:<delay in milliseconds> repeat:<repeat count>
```

> - Script name can include space within the title you want to record
> - `main:` prefix must arrange **at first** so the program can identify the header
> - `offset:` and `repeat:` prefix are **optional**
> - Offset has a default value of `100` milliseconds
> - Repeat count over here is **repeat for all actions defined**
> - Repeat count `0` is defined as **infinite loop**
> - Repeat count has a default value of `0`

### Looping

```
loop_start:<loop count>
    type:<sentence> offset:<delay in milliseconds> repeat:<repeat count>
    press:<key syntax> offset:<delay in milliseconds> repeat:<repeat count>

    loop_start:<loop count>
        type:<sentence> offset:<delay in milliseconds> repeat:<repeat count>
        press:<key syntax> offset:<delay in milliseconds> repeat:<repeat count>
    loop_end
loop_end
```

> - Loop count `0` is defined as **infinite loop**
> - Loop count has a default value of `0`

## Examples

### Spam "I love you" every 3 seconds

```
main:I Love You Spamming offset:3000
type:I love you
press:enter
```

### Spam copied text

```
press:paste
press:enter offset:500
```

### Tatsu pet train 20 times and walk 10 times and pause for 600 seconds (Infinite Loop)

```
main:Tastu Test offset:600000

loop_start:20
    type:t!tg train
    press:enter offset:4500
loop_end

loop_start:5
    loop_start:2
        type:t!tg walk
        press:enter offset:4500
    loop_end
    
    type:t!tg feed
    press:enter offset:4500
loop_end
```

## Appendix

### Key List (for `press:` prefix)

| Key Name     | Key Syntax                               |
|--------------|------------------------------------------|
| Start        | `start` `windows_key` `window` `windows` |
| Left         | `left`                                   |
| Up           | `up`                                     |
| Down         | `down`                                   |
| F1           | `F1`                                     |
| F2           | `F2`                                     |
| F3           | `F3`                                     |
| F4           | `F4`                                     |
| F5           | `F5`                                     |
| F6           | `F6`                                     |
| F7           | `F7`                                     |
| F8           | `F8`                                     |
| F9           | `F9`                                     |
| F10          | `F10`                                    |
| F11          | `F11`                                    |
| F12          | `F12`                                    |
| Copy         | `copy` `ctrl+c`                          |
| Cut          | `cut` `ctrl+x`                           |
| Paste        | `paste` `ctrl+v`                         |
| Escape       | `esc`                                    |
| Enter        | `enter` `return` `\n`                    |
| Space        | `space`                                  |
| Control      | `ctrl`                                   |
| Shift        | `shift`                                  |
| Alt          | `alt`                                    |
| Tab          | `tab`                                    |
| Context Menu | `context_menu`                           |
| Number Lock  | `num` `numlk` `num_lock`                 |
| Caps Lock    | `caps` `capslk` `caps_lock`              |
| Scroll Lock  | `scr` `scrlk` `scroll_lock`              |
| Number Pad 1 | `num1`                                   |
| Number Pad 2 | `num2`                                   |
| Number Pad 3 | `num3`                                   |
| Number Pad 4 | `num4`                                   |
| Number Pad 5 | `num5`                                   |
| Number Pad 6 | `num6`                                   |
| Number Pad 7 | `num7`                                   |
| Number Pad 8 | `num8`                                   |
| Number Pad 9 | `num9`                                   |
| Number Pad 0 | `num0`                                   |
