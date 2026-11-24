
# Adaptive Traffic Signal Scheduling Algorithm

A preliminary algorithm design for adaptive traffic signal scheduling at a four-way intersection.

## Overview

Traffic congestion at urban intersections can lead to unnecessary waiting times, inefficient road usage, and delays.

This project explores a software-based approach to adaptive traffic signal scheduling, motivated by traffic conditions observed in Biratnagar, Nepal.

The proposed approach focuses on making two connected decisions:

1. **Queue Prioritization:** Selecting the road based on the longest individual vehicle waiting time.
2. **Dynamic Green-Time Allocation:** Calculating green signal duration based on the selected road's queue length.

The objective is to explore whether combining these decisions can provide a more responsive alternative to conventional fixed-time signal scheduling.

## Proposed Approach

The preliminary design uses the following logic:

- Consider the four approaches: North, East, South, and West.
- Ignore approaches with empty queues.
- Prioritize the approach whose longest-waiting vehicle has waited the longest.
- If waiting times are equal, consider queue length as a tie-breaker.
- Calculate green duration according to queue size.
- Apply minimum and maximum green-time limits.

## Algorithm Formulation

**Priority score:**

P(i) = W(i)

Where:
- P(i) = Priority of approach i
- W(i) = Longest individual vehicle waiting time on approach i

**Green-time calculation:**

G_raw = T_s + (Q(i) × T_v)

G = min(G_max, max(G_min, G_raw))

Where:
- Q(i) = Queue length of selected approach
- T_s = Base green time
- T_v = Additional time per queued vehicle
- G_min = Minimum green duration
- G_max = Maximum green duration

These are preliminary heuristic formulas. Their parameters require testing and calibration.

## Project Scope

The initial version focuses on a single isolated four-way intersection.

It does not currently include:
- Real-time camera-based vehicle detection
- Physical traffic signal hardware
- Pedestrian crossing management
- Coordination between multiple intersections

## Current Status

<preliminary>
</preliminary>

**Current stage:** Preliminary algorithm design and documentation.

Planned work:
- Java implementation
- Functional test cases
- Traffic simulation
- Comparison with fixed-time signal scheduling
- Performance evaluation

No performance improvements or effectiveness claims are made at this stage.

## Technology

- Java (planned implementation)
- Algorithm design and simulation (planned)

## Motivation

This project was initiated while exploring practical, locally relevant problems for an upcoming open-innovation hackathon.

The goal is to understand, implement, and evaluate a simple adaptive scheduling approach rather than build an unnecessarily complex traffic management system.

## Documentation

Detailed algorithm documentation is available in the [`docs/`](docs/) directory.

## Acknowledgment

AI tools were used as assistance during the initial exploration and documentation process. The algorithm design, implementation, testing, and evaluation will be further reviewed and developed.

## License

To be determined.
