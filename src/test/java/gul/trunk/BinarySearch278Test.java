package gul.trunk;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BinarySearch278Test {

    @Mock
    private VersionControl versionControl;

    private BinarySearch278 binarySearch278;

    @BeforeEach
    public void setup() {
        binarySearch278 = new BinarySearch278(versionControl);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 100, 1000, Integer.MAX_VALUE - 1, Integer.MAX_VALUE})
    void findsFirstBadVersion(int firstBadVersion) {
        when(versionControl.isBadVersion(intThat(it -> it < firstBadVersion))).thenReturn(false);
        when(versionControl.isBadVersion(intThat(it -> it >= firstBadVersion))).thenReturn(true);

        var result = binarySearch278.firstBadVersion(Integer.MAX_VALUE);

        verify(versionControl, atLeastOnce()).isBadVersion(anyInt());
        assertEquals(firstBadVersion, result);
    }
}