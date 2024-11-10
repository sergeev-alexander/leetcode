package alexander.sergeev.leetcode.tasks;

// 2296. Design a Text Editor
class a2296 {

    /*
    Design a text editor with a cursor that can do the following:
    Add text to where the cursor is.
    Delete text from where the cursor is (simulating the backspace key).
    Move the cursor either left or right.
    When deleting text, only characters to the left of the cursor will be deleted.
    The cursor will also remain within the actual text and cannot be moved beyond it.
    More formally, we have that 0 <= cursor.position <= currentText.length always holds.
    Implement the TextEditor class:
    TextEditor() Initializes the object with empty text.
    void addText(string text) Appends text to where the cursor is.
    The cursor ends to the right of text.
    int deleteText(int k) Deletes k characters to the left of the cursor.
    Returns the number of characters actually deleted.
    string cursorLeft(int k) Moves the cursor to the left k times.
    Returns the last min(10, len) characters to the left of the cursor,
    where len is the number of characters to the left of the cursor.
    string cursorRight(int k) Moves the cursor to the right k times.
    Returns the last min(10, len) characters to the left of the cursor,
    where len is the number of characters to the left of the cursor.
     */

    // BEATS 45%
    private StringBuilder stringBuilder;
    private int position;

    public a2296() {
        stringBuilder = new StringBuilder();
        position = 0;
    }

    public void addText(String text) {
        if (text == null) return;
        if (stringBuilder.isEmpty()) {
            stringBuilder.append(text);
            position = text.length();
        } else {
            stringBuilder.insert(position, text);
            position += text.length();
        }
    }

    public int deleteText(int k) {
        int deletedCount = 0;
        if (position - k <= 0) {
            stringBuilder.delete(0, position);
            deletedCount = position;
            position = 0;
        } else {
            stringBuilder.delete(position - k, position);
            position -= k;
            deletedCount = k;
        }
        return deletedCount;
    }

    public String cursorLeft(int k) {
        String s = "";
        if (position > k) {
            position -= k;
            s = stringBuilder.substring(Math.max(0, position - 10), position);
        } else {
            position = 0;
        }
        return s;
    }

    public String cursorRight(int k) {
        String s = "";
        if (stringBuilder.length() <= k) {
            position = stringBuilder.length();
            s = stringBuilder.substring(Math.max(0, position - 10), position);
        } else {
            if (position + k < stringBuilder.length()) {
                position += k;
                s = stringBuilder.substring(Math.max(position - 10, 0), position);
            } else {
                position = stringBuilder.length();
                s = stringBuilder.substring(Math.max(position - 10, 0), stringBuilder.length());
            }
        }
        return s;
    }
}
