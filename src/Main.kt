//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

// Concept Note:
// Group 3-[Michelle Muiruri-174904,Angel Muthoni-189733,Fareed Kamau-193339,Nicole Indimuli-191322,Muli Munyithya-184070,Tichina Naitore-188142]

fun main() {
    val appName = "Community Infrastructure Reporting Management"
    val reportId: Int = 1001
    val faultType: String = "Pothole"
    val reportedByAdmin: Boolean = false
    val severityCode: Char = 'H'

    var status = "Pending"
    var totalReportsToday = 5
    var averageResponseHours = 24.5

    val location = "Kayole, Nairobi"
    val monthsSinceReported = 2

    status = "In progess"
    //--something to be here guyyss!!!

    println("=".repeat(40))
    println(appName)
    println("=".repeat(40) )
    println()
    println("Report ID: $reportId")
    println("FaultType: $faultType")
    println("Location: $location")
    println("Current Status: $status")
    println("SeverityCode: $severityCode")
    println("ReportedByAdmin: $reportedByAdmin")
    println()

    println("Total reports logged today: ${totalReportsToday}")
    println("AverageResponse time: ${averageResponseHours} hours")
    println("Months since first reported: ${monthsSinceReported}")
    println("=".repeat(40))



}