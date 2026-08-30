fun SubmitReport() {
    printHeader("REPORT A NEW FAULT")

    println("select the type of fault")
    for (i in VALID_FAULT_TYPES.indices ){
        println("${i + 1}. ${VALID_FAULT_TYPES[i]}")
    }
 print("> ")
 val typechoice = readLine()?.toIntOrNull()
  val faultType = if (typechoice = null && typeChoice in 1..VALID_FAULT_TYPES.size){
      VALID_FAULT_TYPES[typeChoice - 1]
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
        severitycode = 'M',
        isResolved = false,
        )
    reports.add(newReport)
    nextId++
    println("\nReport submitted successfully. ID: ${newReport.id}")
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