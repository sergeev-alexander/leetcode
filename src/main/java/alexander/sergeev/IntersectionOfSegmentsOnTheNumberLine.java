package alexander.sergeev;

public class IntersectionOfSegmentsOnTheNumberLine {

    public static void main(String[] args) {

    }

    public static String getIntersection(int a1, int a2, int b1, int b2) {
        int aStart;
        int aEnd;
        int bStart;
        int bEnd;
        if (a1 <= b1) {
            aStart = Math.min(a1, a2);
            aEnd = Math.max(a1, a2);
            bStart = Math.min(b1, b2);
            bEnd = Math.max(b1, b2);
        } else {
            aStart = Math.min(b1, b2);
            aEnd = Math.max(b1, b2);
            bStart = Math.min(a1, a2);
            bEnd = Math.max(a1, a2);
        }
        String result = "Пересечения нет";

        if (aEnd == bStart) {
            result = "" + aEnd;
        }

        if (aStart == bStart) {
            if (aEnd < bEnd) {
                result = aStart + " " + aEnd;
            } else {
                result = aStart + " " + bEnd;
            }
        }

        if (aEnd == bEnd) {
            if (aStart > bStart) {
                result = aStart + " " + aEnd;
            } else {
                result = bStart + " " + aEnd;
            }
        }

        if (aStart < bStart && bEnd < aEnd) {
            result = bStart + " " + bEnd;
        }

        if (aStart < bStart && bStart < aEnd && aEnd < bEnd) {
            result = bStart + " " + aEnd;
        }

        return result;
    }
}
