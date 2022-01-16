package io.jenkins.plugins.coverage;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.gargoylesoftware.htmlunit.ScriptResult;

import org.jenkinsci.test.acceptance.po.PageObject;

/**
 * Coverage-TrendChart is displayed twice. Therefore, this util is used in
 * {@link CoverageReport} and {@link MainPanel}.
 */
class TrendChartUtil {

    /**
     * Returns a chart's data by its id.
     * @param elementId of chart.
     * @return data as json.
     */
    static String getChartsDataById(final PageObject pageObject, final String elementId) {
        if(isChartDisplayed(pageObject, elementId)) {
            Object result = pageObject.executeScript(String.format(
                    "delete(window.Array.prototype.toJSON) %n"
                            + "return JSON.stringify(echarts.getInstanceByDom(document.getElementById(\"%s\")).getOption())",
                    elementId));
            ScriptResult scriptResult = new ScriptResult(result);

            return scriptResult.getJavaScriptResult().toString();
        }
        return null;
    }

    /**
     * Returns if chart is displayed.
     * @param elementId of chart
     * @return if chart is displayed
     */
    static boolean isChartDisplayed(final PageObject pageObject, final String elementId){
        try{
            WebElement chart = pageObject.find(By.id(elementId));
            if(chart!=null && chart.isDisplayed()){
                return true;
            }
        }
        catch (NoSuchElementException exception) {
            return false;
        }
        return false;
    }

}
