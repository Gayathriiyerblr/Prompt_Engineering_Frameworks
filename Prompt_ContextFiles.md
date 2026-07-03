context files 
WHY?
Create reusable context templates for consistent prompts

1. While repeating same content - Write once, reuse everywhere
2. Inconsistent prompts - Standardized structure
3. Missing Information - Checklist ensure completeness
4. Onboarding new team members - Ready-to use templates

---------------------------------------------------------------------------
## Template 1: Project Context(Huge documents want to summarize quickly/take a note to be referred quickly always)
**File:** context_project.md 

# Project Context

## Application
- **Name:** [Application Name]
- **Type:** [Web / Mobile / API / Desktop]
- **Domain:** [E-commerce / Banking / Healthcare / etc.]

## Tech Stack
- **Frontend:** [React / Angular / Vue / etc.]
- **Backend:** [Node.js / Java / Python / etc.]
- **Database:** [PostgreSQL / MongoDB / etc.]
- **API Type:** [REST / GraphQL / SOAP]

## Environment
- **Dev URL:** [URL]
- **Staging URL:** [URL]
- **Prod URL:** [URL]

## Key Constraints
- [Constraint 1]
- [Constraint 2]

---------------------------------------------------------------------------------
Prompt - Can you please creates a context out of it for my notes so that I can remember this everytime.Below is the proper context, <Document/Image/copy paste the details>

-------------------------------------------------------------------------------------------
 ## Template 2: Feature Context(At one notes have all the details for quick reference instead of referring multiple files)
**File:** context_feature.md 

# Feature Context: [Feature Name]

## Overview
[Brief description of the feature]

## User Stories
- As a [user], I want to [action] so that [benefit]

## Acceptance Criteria
- [ ] Criteria 1
- [ ] Criteria 2
- [ ] Criteria 3

## API Endpoints (if applicable)
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST   | /api/... | ... |

## UI Elements
- [Element 1]
- [Element 2]

## Validation Rules
| Field | Rule |
|-------|------|
| Email | Valid format required |

## Error Messages
| Code | Message |
|------|---------|
| 400  | ... |
-----------------------------------------------------------------------------------------
## Template 3: Test Context (Overall summary for reporting)
**File:** context_testing.md

```
# Testing Context

## Scope
- **In Scope:** [Features to test]
- **Out of Scope:** [Features NOT to test]

## Test Data
| Data Type | Value | Purpose |
|-----------|-------|---------|
| Valid email | test@example.com | Happy path |
| Invalid email | not-an-email | Negative test |

## Test Environment
- **Browser:** [Chrome / Firefox / Safari]
- **Device:** [Desktop / Mobile / Tablet]
- **OS:** [Windows / macOS / Linux]

## Dependencies
- [Service 1] must be running
- [Database] must have seed data

## Known Issues
- [Issue 1 - workaround]
------------------------------------------------------------------------------------------
## Template 4: Anti-Hallucination Context
**File:** context_constraints.md

# Constraints & Rules

## MUST Follow
- Use ONLY information from provided documents
- Do NOT assume undocumented features
- Mark uncertainties as "[NEEDS CLARIFICATION]"
- If missing info, state "Not specified in requirements"

## MUST NOT Do
- Invent error codes or messages
- Assume validation rules not documented
- Create fictional API endpoints
- Guess system behavior

## Output Rules
- Use specified format exactly
- Include all required fields
- Mark assumptions with "[ASSUMPTION]"
--------------------------------------------------------------------------------------------

## Quick Start: Create Your First Template
1. Create `context_project.md`  with your app details
2. Create `context_constraints.md`  with anti-hallucination rules
3. Create feature-specific context files as needed
4. Reference templates in your prompts



