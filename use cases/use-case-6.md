# USE CASE 6: Produce a report on the top N populated countries in a region where N is provided by the user

## CHARACTERISTIC INFORMATION

### Goal in Context

As an *employee* I want *to produce a report on the top N populated countries in a region where N is provided by the employee* so that *I can easily access to this population information.*

### Scope

Organisation.

### Level

Primary task.

### Preconditions

Database contains population information of countries in a region.

### Success End Condition

A report is available to all employees with the top N populated countries in a region where N is provided by the employee
The report should include:
1. The name of the country
2. The total population of the country.
3. The total population of the country living in cities (including a %).
4. The total population of the country not living in cities (including a %).

### Failed End Condition

No report is produced.

### Primary Actor

Employee of Organisation.

### Trigger

Employee has access to software to view report.

## MAIN SUCCESS SCENARIO

1. Employee selects the report type they want to view.
2. Employee chooses the region they want to view information from
3. Employee enters the number of countries they want to view information from
4. Employee is shown report

## EXTENSIONS
3. **Employee entered an invalid number**
    1. Employee informed by software number is invalid
    2. Employee is prompted to enter another number

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: 