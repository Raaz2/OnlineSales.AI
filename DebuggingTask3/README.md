# Integer Computation Script

This Python script performs different computations on an integer input `n` based on the following conditions:

1. If `n` is less than 10, it calculates the square of `n`.
   Example: `4` => `16`

2. If `n` is between 10 and 20 (inclusive), it calculates the factorial of `(n-9)`.
   Example: `15` => `120`

3. If `n` is greater than 20, it calculates the sum of all integers between 1 and `(n-20)`.
   Example: `25` => `15`

## Bugs Fixed

- The script has been fixed to handle the factorial calculation correctly by changing `(n - 10)` to `(n - 9)` to include the correct range of values.
- The sum of numbers has been corrected by changing `(out - lim)` to `(out + lim)` to calculate the sum of numbers correctly.

## Usage

1. Clone or download the script to your local machine.

2. Open your terminal or command prompt.

3. Run the script using Python by entering the following command:

   ```
   python app.py
   ```

4. Enter an integer when prompted.

5. The script will compute the result based on the conditions and display it in the console.

## Example

```
Enter an integer: 15
Result: 120
```

## Bug Fixes

- Changed `(n - 10)` to `(n - 9)` for the factorial calculation to include the correct range.
- Changed `(out - lim)` to `(out + lim)` for the sum of numbers calculation to be accurate.