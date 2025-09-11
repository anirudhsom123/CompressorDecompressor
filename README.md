# Image Compressor & Decompressor

A simple Java desktop application for compressing and decompressing files using a clean graphical user interface.

## Features

- **File Compression**: Reduce file sizes to save storage space
- **File Decompression**: Restore compressed files to their original format
- **User-Friendly GUI**: Easy-to-use interface built with Java Swing
- **Cross-Platform**: Runs on Windows, macOS, and Linux

## How It Works

The application uses Java's built-in compression algorithms to:
1. **Compress**: Takes input files and reduces their size while maintaining data integrity
2. **Decompress**: Restores compressed files back to their original format

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Java Runtime Environment (JRE)

### Running the Application
1. Clone this repository:
   ```bash
   git clone https://github.com/anirudhsom123/ImageCompressorDecompressor.git
   ```

2. Navigate to the project directory:
   ```bash
   cd ImageCompressorDecompressor
   ```

3. Compile and run the application:
   ```bash
   javac GUI/AppFrame.java
   java GUI.AppFrame
   ```

## Usage

1. Launch the application
2. **To Compress**: Click "Compress File" and select the file you want to compress
3. **To Decompress**: Click "Decompress File" and select the compressed file
4. The processed file will be saved in the same directory

## Project Structure

```
----GUI/
     ----AppFrame.java          # Main GUI interface
     ----Main.java
----comp_decomp/
     ----compressor.java        # Compression logic
     ----decompressor.java      # Decompression logic
----README.md
```

## Technologies Used

- **Java**: Core programming language
- **Java Swing**: GUI framework
- **Java IO**: File handling operations

## Contributing

This is a beginner Java project. Feel free to fork and improve!

## License

Open source project - feel free to use and modify.
