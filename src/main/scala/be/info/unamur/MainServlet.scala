package be.info.unamur

import org.scalatra.ScalatraServlet
import org.scalatra.scalate.ScalateSupport
import com.phidgets.InterfaceKitPhidget
import com.phidgets.event.{SensorChangeEvent, SensorChangeListener}

class MainServlet extends ScalatraServlet with ScalateSupport {
  before() {
    contentType = "text/html"
  }

  get("/") {

    val ifk = new InterfaceKitPhidget()

    val scl = new SensorChangeListener {
      override def sensorChanged(sensorChangeEvent: SensorChangeEvent): Unit = {
        System.out.println("Value changed : " + sensorChangeEvent.getValue)
      }
    }

    ifk addSensorChangeListener scl

    ifk openAny()
    System.out.println("OpenAny : OK")
    System.out.println("Waiting for attachement..")
    ifk waitForAttachment()
    System.out.println("WaitForAttachement : OK")
    val sv_1 : Int  = ifk.getSensorValue(6)
    //ifk close()
    ssp("/WEB-INF/templates/views/index.ssp", "sensor_value" -> sv_1)
  }
}