//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

// Concept Note:https://docs.google.com/document/d/1SltAn1g8NbZDkaD7HiqKc_ehyUfXkjv0by-qkkCwXc4/edit?usp=sharing
// GitHub-View our collaboration : https://github.com/Michelle-Muirurii/Community-Reporting-Infrastructure.git
// Group 3-[Michelle Muiruri-174904,
//          Angel Muthoni-189733,
//          Fareed Kamau-193339,
//          Nicole Indimuli-191322,
//          Muli Junior-184070,
//          Tichina Naitore-188142]

data class Report (
    val id: Int,
    val faultType: String,
    val location: String,
    val severityCode: Char,
    var isResolved: Boolean
)

const val APP_NAME ="Community Infrastructure Reporting"
val VALID_FAULT_TYPES = listOf("Pothole","Broken Streetlight","Blocked Drainage")
val VALID_STATUSES = listOf("Pending","In Progress","Resolved")

val reports = mutableListOf<Report>()
var nextId = 1


fun main() {
    val reportId: Int = 1001
    val faultType: String = "Pothole"
    val reportedByAdmin: Boolean = false
    val severityCode: Char = 'H'

    var status = "Pending"
    var totalReportsToday = 5
    var averageResponseHours = 24.5

    val location = "Kayole, Nairobi"
    val monthsSinceReported = 2

    status = "In progress"

// : DATA TYPES(Muli)
    val reporterName: String = "Njeri Michelle"
    val roadCondition: String = "Damaged"
    val numberOfPhotos: Int = 3
    val estimatedRepairCost: Double = 15000.50
    val isEmergency: Boolean = true
    val priorityCode: Char = 'H'

    println("=".repeat(40))
    println(APP_NAME)
    println("=".repeat(40) )
    println()
    println("Report ID: $reportId")
    println("FaultType: $faultType")
    println("Location: $location")
    println("Current Status: $status")
    println("SeverityCode: $severityCode")
    println("ReportedByAdmin: $reportedByAdmin")
    println("Reported By: $reporterName")
    println("Road Condition: $roadCondition")
    println("Number of Photos: $numberOfPhotos")
    println("Estimated Repair Cost: KES $estimatedRepairCost")
    println("Emergency Report: $isEmergency")
    println("Priority Code: $priorityCode")
    println()
    println("Total reports logged today: ${totalReportsToday}")
    println("AverageResponse time: ${averageResponseHours} hours")
    println("Months since first reported: ${monthsSinceReported}")
    println("=".repeat(40))

    printHeader("COMMUNITY-REPORTING-INFRASTRUCTURE")
    println("Welcome! Report Infrastructure Faults and Track their Status.\n")


    var running = true
    while (running) {
        printMenu()
        print("> ")
        when (readLine()?.trim()) {
            "1" -> submitReport()
            "2" -> viewAllReports()
            "3" -> viewReportsByStatus()
            "4" -> updateReportStatus()
            "5" -> {
                println("\nGoodbye!")
                running = false
            }
            else -> println("\nInvalid Option. Please Choose 1-5.\n")
        }
    }
}


fun submitReport() {
    printHeader("REPORT A NEW FAULT")

    println("select the type of fault")
    for (i in VALID_FAULT_TYPES.indices ){
        println("${i + 1}. ${VALID_FAULT_TYPES[i]}")
    }
    print("> ")
    val typechoice = readLine()?.toIntOrNull()
    val faultType = if (typechoice != null && typechoice in 1..VALID_FAULT_TYPES.size){
        VALID_FAULT_TYPES[typechoice - 1]
    } else {
        "Other"
    }
    println("\nEnter the location of the fault:")
    print(">")
    val Location = readLine()?.trim().orEmpty().ifEmpty { "Unspecified location"}
    println("\nBriefly describe the fault:")
    print("> ")
    val description = readLine()?.trim().orEmpty().ifEmpty { "No description provided"}

    val newReport = Report(
        id = nextId,
        faultType = faultType,
        location = Location,
        severityCode = 'M',
        isResolved = false,
    )
    reports.add(newReport)
    nextId++
    println("\nReport submitted successfully. ID: ${newReport.id}")
    println("Description: $description")
}


    fun printHeader(title: String) {
        println("=".repeat (40))
        println(title)
        println("=".repeat (n=40))

    }
    fun printReport(report: Report){
        println("---------------------")
        println("Report ID: ${report.id}")
        println("Fault Type: ${report.faultType}")
        println("location: ${report.location}")
        println("status: ${if (report.isResolved) "Resolved" else "Not Resolved"}")
        println("------------------------")
    }

fun printMenu() {
    println("----------------------------------------")
    println("MAIN MENU")
    println("----------------------------------------")
    println("1. Report a new infrastructure fault")
    println("2. View all reports")
    println("3. View reports by status")
    println("4. Update a report's status (Admin)")
    println("5. Exit")
    println("----------------------------------------")
}

fun viewAllReports() {
    printHeader("ALL REPORTED FAULTS")
    if (reports.isEmpty()) {
        println("No reports submitted yet.\n")
        return
    }
    for (report in reports) {
        printReport(report)
    }
}

fun viewReportsByStatus() {
    printHeader("VIEW REPORTS BY STATUS")
    println("1. Pending   2. Resolved")
    print("> ")
    val choice = readLine()?.toIntOrNull()

    val filtered = when (choice) {
        1 -> reports.filter { !it.isResolved }
        2 -> reports.filter { it.isResolved }
        else -> emptyList()
    }

    if (filtered.isEmpty()) {
        println("No matching reports.\n")
    } else {
        for (report in filtered) {
            printReport(report)
        }
    }
}

fun updateReportStatus() {
    printHeader("UPDATE REPORT STATUS")
    print("Enter Report ID: ")
    val id = readLine()?.toIntOrNull()

    val report = reports.find { it.id == id }
    if (report == null) {
        println("No report found with that ID.\n")
        return
    }

    report.isResolved = true
    println("Report ${report.id} marked as Resolved.")
}
