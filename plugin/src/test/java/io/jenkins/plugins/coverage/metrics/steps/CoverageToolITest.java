package io.jenkins.plugins.coverage.metrics.steps;

import org.junit.jupiter.api.Test;

import hudson.util.ListBoxModel;
import io.jenkins.plugins.util.IntegrationTestWithJenkinsPerSuite;

import static org.assertj.core.api.Assertions.*;


/**
 * Tests the class {@link CoverageTool}.
 *
 * @author Valentin Delaye
 */
class CoverageToolITest extends IntegrationTestWithJenkinsPerSuite {

    @Test
    void shouldFillParserItems() {
        CoverageTool.CoverageToolDescriptor descriptor = getJenkins().getInstance().getDescriptorByType(CoverageTool.CoverageToolDescriptor.class);
        ListBoxModel list = descriptor.doFillParserItems();
        assertThat(list).hasSize(5);
    }
}
