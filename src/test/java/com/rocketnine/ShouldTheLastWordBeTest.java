package com.rocketnine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShouldTheLastWordBeTest {

    @Test
    public void fails_locally_should_break_azure_build() {
        Assertions.fail("Paul broke the build");
    }

}
