# USE CASE: 3 Produce a report on all the countries in a region organised by largest population to smallest.

## CHARACTERISTIC INFORMATION

### Goal in Context

As an *employee* I want *to produce a report on all the countries in a region organised by largest population to smallest* so that *I can easily access to this population information.*

### Scope

Organisation.

### Level

Primary task.

### Preconditions

Database contains population information of countries in the world.

### Success End Condition

A report is available to all employees with all the countries in a region organised by largest population to smallest with:
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
2. Employee enters the region they want to view information from
3. Employee is shown report

## EXTENSIONS

3. **Region does not exist**
    1. Employee informed by software region does not exist
    2. Employee is prompted to enter another region

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.2.0 12/10/2026