package gul.trunk;

public class BinarySearch278 {

    private final VersionControl versionControl;

    public BinarySearch278(VersionControl versionControl) {
        this.versionControl = versionControl;
    }

    public int firstBadVersion(int n) {
        int down = 1;
        int up = n;

        while (down <= up) {
            int v = down + (up - down) / 2;

            if (isBadVersion(v)) {
                if (!isBadVersion(v-1)) {
                    return v;
                } else {
                    up = v - 1;
                }
            } else {
                down = v + 1;
            }
        }

        throw new RuntimeException("Failed to find firs broken version!");
    }

    private boolean isBadVersion(int v) {
        return versionControl.isBadVersion(v);
    }

}