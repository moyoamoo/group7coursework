# USE CASE: 16 Produce a report on the top N populated cities in a district where N is provided by the user

## CHARACTERISTIC INFORMATION

### Goal in Context

As an *employee* I want *to produce a report on the top N populated cities in a district where N is provided by the user* so that *I can easily access to this population information.*

### Scope

Organisation.

### Level

Primary task.

### Preconditions

Database contains population information of cities in the world.

### Success End Condition

A report is available to all employees with The top N populated cities in a district where N is provided by the user.
The report should include:
1. The name of the city.
2. The country the city is in.
3. The district the city is in
4. The total population of the city.

### Failed End Condition

No report is produced.

### Primary Actor

Employee of Organisation.

### Trigger

Employee has access to software to view report.

## MAIN SUCCESS SCENARIO

1. Employee selects the report type they want to view.
2. Employee chooses the district they want to view information from
3. Employee enters the number of cities they want to view information from
4. Employee is shown report

## EXTENSIONS

3. **Employee entered an invalid number**
    1. Employee informed by software number is invalid
    2. Employee is prompted to enter another number


## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: 