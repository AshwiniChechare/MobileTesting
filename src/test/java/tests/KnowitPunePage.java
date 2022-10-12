package tests;

import base.BaseClass;
import com.google.common.collect.ImmutableList;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.Test;

import java.time.Duration;

public class KnowitPunePage extends BaseClass {
    //https://www.knowit.eu/
    protected Dimension windowSize;

    @Test
    public void validatePlacementStudentName() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Chrome")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.id("com.android.chrome:id/menu_button")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='New tab']")).click();
        driver.findElement(By.id("com.android.chrome:id/search_box_text")).click();
        driver.findElement(By.id("com.android.chrome:id/url_bar")).sendKeys("https://know-it.co.in/");
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));

        Thread.sleep(6000);
        scroll("DOWN",0.3);
        scroll1("RIGHT",0.8);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    protected void swipe(Point start, Point end, Duration duration) {
        boolean isAndroid = driver instanceof AndroidDriver;
        PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence swipe = new Sequence(input, 0);
        swipe.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), start.x, start.y));
        swipe.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        if (isAndroid) {
            duration = duration.dividedBy(3);
            swipe.addAction(input.createPointerMove(duration, PointerInput.Origin.viewport(), end.x, end.y));
            swipe.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            driver.perform(ImmutableList.of(swipe));
        } else {
            swipe.addAction(new Pause(input, duration));
            duration = Duration.ZERO;
            swipe.addAction(input.createPointerMove(duration, PointerInput.Origin.viewport(), end.x, end.y));
            swipe.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            driver.perform(ImmutableList.of(swipe));
        }
    }
    private Dimension getWindowSize() {
        if (windowSize == null) {
            windowSize = driver.manage().window().getSize();
        }
        return windowSize;
    }

    protected void scroll(String dir, double distance) {

        for (int i = 0; i <= 40; i++) {
           // System.out.println(i);
            try {
                if (driver.findElement(By.xpath("//android.view.View[@text='Welcome to KNOW-IT']")).isDisplayed()) {
                    break;
                }
            } catch (Exception e) {
                Dimension size = getWindowSize();
                if (size == null) {
                    System.out.println("element is not found");
                }
                Point midPoint = new Point((int) (size.width * 0.5), (int) (size.height * 0.5));
                int top = midPoint.y - (int) ((size.height * distance) * 0.5);
                int bottom = midPoint.y + (int) ((size.height * distance) * 0.5);
                int left = midPoint.x - (int) ((size.width * distance) * 0.5);
                int right = midPoint.x + (int) ((size.width * distance) * 0.5);
                Duration SCROLL_DUR = Duration.ofMillis(1000);
                if (dir.equalsIgnoreCase("UP")) {
                    swipe(new Point(midPoint.x, top), new Point(midPoint.x, bottom), SCROLL_DUR);
                } else if (dir.equalsIgnoreCase("DOWN")) {
                    swipe(new Point(midPoint.x, bottom), new Point(midPoint.x, top), SCROLL_DUR);
                } else if (dir.equalsIgnoreCase("LEFT")) {
                    swipe(new Point(left, midPoint.y), new Point(right, midPoint.y), SCROLL_DUR);
                } else if(dir.equalsIgnoreCase("RIGHT")) {
                    swipe(new Point(right, midPoint.y), new Point(left, midPoint.y), SCROLL_DUR);
                }
            }
        }
    }
    protected void scroll1(String dir, double distance) {

        for (int i = 0; i <= 40; i++) {
             System.out.println(i);
            try {
                if (driver.findElement(By.xpath("//android.widget.TextView[@text='SWAPNIL PAWAR']")).isDisplayed()) {
                    break;
                }
            } catch (Exception e) {
                Dimension size = getWindowSize();
                if (size == null) {
                    System.out.println("element is not found");
                }
                Point midPoint = new Point((int) (size.width * 0.5), (int) (size.height * 0.5));
                int top = midPoint.y - (int) ((size.height * distance) * 0.5);
                int bottom = midPoint.y + (int) ((size.height * distance) * 0.5);
                int left = midPoint.x - (int) ((size.width * distance) * 0.5);
                int right = midPoint.x + (int) ((size.width * distance) * 0.5);
                Duration SCROLL_DUR = Duration.ofMillis(1000);
                if (dir.equalsIgnoreCase("UP")) {
                    swipe(new Point(midPoint.x, top), new Point(midPoint.x, bottom), SCROLL_DUR);
                } else if (dir.equalsIgnoreCase("DOWN")) {
                    swipe(new Point(midPoint.x, bottom), new Point(midPoint.x, top), SCROLL_DUR);
                } else if (dir.equalsIgnoreCase("LEFT")) {
                    swipe(new Point(left, midPoint.y), new Point(right, midPoint.y), SCROLL_DUR);
                } else {
                    swipe(new Point(right, midPoint.y), new Point(left, midPoint.y), SCROLL_DUR);
                }
            }
        }
    }
}
