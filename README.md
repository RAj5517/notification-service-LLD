# Low Level Design – Notification System

This repository documents the Low Level Design (LLD) discussion for designing a **Notification System**, commonly asked in backend and system design interviews.

The goal is to design a **plug-and-play, extensible notification service** following SOLID principles and appropriate design patterns.

---

## 📌 Problem Statement

Design a **Notification System** that can send notifications to users through multiple channels such as:

- Email
- SMS
- Popup notifications

The system should be extensible enough to support additional channels (e.g. WhatsApp, Push Notifications) in the future **without modifying existing code**.

---

## 🎯 Functional Requirements

1. The system should allow sending notifications through multiple channels.
2. A single notification may be delivered through **multiple channels simultaneously**.
3. Notifications should be **dynamically customizable**, such as:
   - Adding timestamps
   - Adding signatures
   - Adding headers or footers
4. The system should store **all sent notifications** for history tracking.
5. Every notification should be **logged** when sent.

---

## ⚙️ Non-Functional Requirements

1. The system must follow **SOLID design principles**.
2. It should be **plug-and-play**, requiring minimal client-side integration.
3. The design should be **highly extensible**:
   - Adding a new notification channel should not affect existing code.
   - Adding new notification features should not require changes to core classes.
4. The system should avoid tight coupling between components.
5. The notification service should maintain a **single source of truth** for notification history.

---

## ❓ Interview Clarifications (Assumptions)

- Delivery mechanisms (Email/SMS/etc.) can be mocked or simulated.
- Persistence can be in-memory for now.
- Failure handling, retries, and async delivery are out of scope unless explicitly asked.
- Authentication and user management are not part of this design.

---

## 🧠 Design Expectations

- Identify core entities and responsibilities.
- Decide where interfaces are required vs concrete implementations.
- Apply suitable design patterns where needed.
- Keep the client API minimal and clean.
- Ensure future extensibility is straightforward.

---

## 🚀 Scope of Discussion

This repository focuses on:
- Requirement analysis
- Design reasoning
- Pattern selection
- Clean object-oriented design

Implementation details will be added incrementally during discussion.

