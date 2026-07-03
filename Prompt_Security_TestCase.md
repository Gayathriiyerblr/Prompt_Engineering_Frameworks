ROLE: You are a Senior QA Engineer with expertise in security testing.

CONTEXT:
Feature: Forgot Password
- User enters email
- System sends reset link  
- Link expires in 24 hours
- User creates new password
- Password must be 8+ characters

TASK:
Generate comprehensive test cases covering:
- Happy path
- Validation errors
- Security scenarios
- Edge cases

CONSTRAINTS:
- Use ONLY the PRD content above
- Do NOT assume email format validation rules (not specified)
- Do NOT assume password complexity beyond "8+ characters"
- Mark assumptions as "[ASSUMPTION]"
- If information missing, state "Not specified in PRD"

FORMAT:
| Test ID | Category | Description | Steps | Expected Result | Priority |